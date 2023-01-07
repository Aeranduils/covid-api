import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { interval } from 'rxjs/internal/observable/interval';

@Component({
  selector: 'app-error-infos',
  templateUrl: './error-infos.component.html',
  styleUrls: ['./error-infos.component.scss']
})
export class ErrorInfosComponent implements OnInit, OnDestroy {

  infos = '';
  private sub: any;
  temps = 0;
  tempsRestant = 0;
  tempsInitial = 0;
  finishedTimer = false;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly router: Router
  ) { }

  ngOnInit(): void {
    console.log('waiting');
    this.sub = this.route.params.subscribe(params => {
      this.tempsInitial = +params['temps'];
    });
    if(this.tempsInitial === 0) {
      this.finishedTimer = true;
    }
    this.startTimer();
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
    
  }

  startTimer() {
    const tempsInitial = this.tempsInitial;
    this.tempsRestant = this.tempsInitial;
    const timer$ = interval(1000);

    const sub = timer$.subscribe(async (sec) => {
      sec = sec+1;
      this.tempsRestant = tempsInitial - sec;
      this.infos = `Réessayer après ${this.tempsInitial} secondes`;
      if (this.tempsRestant <= 0) {
        sub.unsubscribe();
        this.finishedTimer = true;
      }
    });
  }

  backToHome() {
    this.router.navigate(['/centers']);
  }
}
