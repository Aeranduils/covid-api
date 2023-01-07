import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, map, Observable } from 'rxjs';
import { VaccinationCenter } from './vaccination-center';

@Injectable({
  providedIn: 'root'
})
export class VaccinationService {

  CENTERS: VaccinationCenter[]=[
    {id: 1, name: "Hôpital Central", address: "3, Place Carnot", postalCode: "54000", city: "Nancy", openingDate: new Date('2001-01-12')},
    {id: 2, name: "Grand Centre de Vaccination", address: "45, Avenue de Manchester", postalCode: "08000", city: "Charleville-Mézières", openingDate: new Date('1977-04-14')},
    {id: 3, name: "Hôpital de la Gare", address: "2, rue de la Gare", postalCode: "57000", city: "Metz", openingDate: new Date('2005-12-25')},
    {id: 4, name: "Centre-Ville", address: "5, Rue Saint-Jean", postalCode: "54000", city: "Nancy", openingDate: new Date('2000-05-01')}
  ]

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  getAllVaccinationCenter(city: string): Observable<VaccinationCenter[]>{
    return this.httpClient.get<VaccinationCenter[]>("api/public/centers",{observe: 'response'}).pipe(
      map((resp)=>{
        if(!!resp.body){
          return resp.body
        }
        return []
      }, { params: {
          "city": city
        }
      }),
      catchError((err) => {
        console.log(err)
        const temps =  err.headers.get('X-Rate-Limit-Retry-After-Seconds')
        this.router.navigate(['infos/429', temps]);
        return []
      })
    );
  }
}
