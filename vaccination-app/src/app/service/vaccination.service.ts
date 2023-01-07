import { ComponentFactoryResolver, Injectable } from '@angular/core';
import { VaccinationCenter } from '../model/vaccination-center';
import { VaccinationCenterComponent } from '../vaccination-center/vaccination-center.component';

@Injectable({
  providedIn: 'root'
})
export class VaccinationService {

  constructor(private httpClient: HttpClient) { }

  // getAllVaccinationCenter() : VaccinationCenter[]
  // {
  //   return centers;
  // }

  
  getAllVaccinationCenter(city?: string) : Observable<VaccinationCenter[]>{
    return this.httpClient.get<VaccinationCenter[]>('api/public/centers'{
      params: {
        "city": city
      }
    });
  }

  createBooking(book: Booking): Observable<Booking>{
    return this.httpClient.post("api/public/booking", book);
  }
}
