import { Component, ComponentRef, OnInit, ɵresolveComponentResources } from '@angular/core';
import { VaccinationCenter } from '../model/vaccination-center';

@Component({
  selector: 'app-vaccination-center-list',
  templateUrl: './vaccination-center-list.component.html',
  styleUrls: ['./vaccination-center-list.component.css']
})
export class VaccinationCenterListComponent implements OnInit{

  centers: VaccinationCenter[] = [
    {id: 1,name: "Hopital central",address: "Rue du mont",postalCode: "54000",city: "Nancy",openingDate: new Date(1999, 12, 25)},
    {id: 2,name: "Hopital externe",address: "Rue du fg",postalCode: "54000",city: "Metz",openingDate: new Date(1999, 12, 25)},
    {id: 3,name: "Centre des congrès",address: "Rue du mzdfgh",postalCode: "54000",city: "Nancy",openingDate: new Date(1999, 12, 25)},
    {id: 4,name: "Centre médicale du rocher",address: "Rue du picord",postalCode: "54000",city: "Nancy",openingDate: new Date(1999, 12, 25)},
    {id: 5,name: "Mairie de nancy",address: "Rue du msdfg",postalCode: "54000",city: "Nancy",openingDate: new Date(1999, 12, 25)},
  ];

  // centers: VaccinationCenter[] = CENTERS; //ça fait quoi ?
  selected?: VaccinationCenter;

  // Le composant parent traite l’événement:
  onDeleted(center: VaccinationCenter){
    delete this.selected;
    this.centers.splice(this.centers.indexOf(center), 1);
  } 

  constructor() { }

  ngOnInit(): void { 
    // this.service.getAllVaccinationCenter().subscribe(resultCenters=>{
    //   this.centers = resultCenters;
    // });
  }
  
  isSpecialCenter(center: VaccinationCenter){
    return center.city == "Nancy";
  }

  selectCenter(center: VaccinationCenter){
    this.selected=center;
  }

}
