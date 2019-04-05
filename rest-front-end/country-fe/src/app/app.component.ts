import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class Country {
  code: string
  name: string
  region: number
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'country-fe';
  constructor(private http: HttpClient) { }

  countryList: Array<Country>;
  requestList() {
    this.http.get<Country[]>("http://localhost:5000/countries/find-all").subscribe(data => {
      this.countryList = data;
      console.log("Getting list of countries");
    });
  }
}
