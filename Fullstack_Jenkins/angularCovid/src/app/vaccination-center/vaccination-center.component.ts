import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VaccinationCenter } from '../vaccination-center';
import { VaccinationService } from '../vaccination.service';

@Component({
  selector: 'app-vaccination-center',
  templateUrl: './vaccination-center.component.html',
  styleUrls: ['./vaccination-center.component.scss']
})
export class VaccinationCenterComponent implements OnInit {

  @Input() center?: VaccinationCenter
  @Output() deleted = new EventEmitter<VaccinationCenter>();

  delete(){
    this.deleted.emit(this.center);
  }

  /*
  clearName(){
    this.center.name = "";
  }

  isNameNotEmpty(){
    return this.center.name.length>0;
  }
  */

  constructor(private route: ActivatedRoute, private service: VaccinationService) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'))
    this.service.getAllVaccinationCenter("").subscribe(resultCenters=>{
      this.center = resultCenters[id-1];
    });
  }

}
