import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { VaccinationCenter } from '../model/vaccination-center';

@Component({
  selector: 'app-vaccination-center',
  templateUrl: './vaccination-center.component.html',
  styleUrls: ['./vaccination-center.component.css']
})
export class VaccinationCenterComponent implements OnInit {

  @Input() center?: VaccinationCenter;
  @Output() deleted = new EventEmitter<VaccinationCenter>();


  constructor() { }

    // La méthode delete va “émettre” un événement contenant le centre à supprimer.
  delete(){
    this.deleted.emit(this.center);
  }

  ngOnInit(): void { }

  isNameNotEmpty(){
    if (this.center){
      return this.center.name.length>0;
    }
    return false
  }

  clearName(){
    if (this.center){
      this.center.name = "";
    }

  }
}

  // center: VaccinationCenter = {
  //   id: 1,
  //   name: "Hopital gogogo",
  //   address: "Rue du mont",
  //   postalCode: "54000",
  //   city: "Nancy",
  //   openingDate: new Date(1999, 12, 25),  