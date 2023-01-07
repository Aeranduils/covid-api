import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Vaccination COVID';

  constructor(
    private readonly http: HttpClient,
    private readonly router: Router
  ) {}

  infos = '';

  info() {
    this.http.get<any>('api/infos/429', {observe: 'response'})
    .subscribe({
      next: (resp) => {
      console.log(resp);
      console.log(resp.headers.keys());
      const nbToken =  resp.headers.get('X-Rate-Limit-Remaining')
      this.infos = `${nbToken} tokens restants`
    },
    error:  (err) => {
      console.error(err);
      console.log(err.headers.keys());
      const temps =  err.headers.get('X-Rate-Limit-Retry-After-Seconds')
      this.infos = `Réessayer après ${temps} secondes`;
      this.router.navigate(['/infos/429', temps]);
    }
    });
  }
}
