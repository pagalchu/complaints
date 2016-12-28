import { Component, OnInit} from '@angular/core';

@Component({
    selector: 'vault',
    templateUrl: 'app/app.component.html'
})

export class AppComponent implements OnInit{
   ngOnInit(): void {
       //if no session or not login, show the login UI
       console.log("oninit AppComponent...");
    }
}
