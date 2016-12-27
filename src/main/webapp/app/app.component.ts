import { Component } from '@angular/core';

@Component({
    selector: 'vault',
    template: `
        <div>
            <nav class='navbar navbar-default'>
                <div class='container-fluid'>
                    <div class="navbar-header">
                        <a class="navbar-brand" [routerLink]="['/home']">
                            <span class="glyphicon glyphicon-home"></span>
                        </a>
                    </div>
                    <ul class='nav navbar-nav'>
                        <!--<li><a [routerLink]="['/home']">Home</a></li>-->
                        <li><a [routerLink]="['/admin']">Admin</a></li>
                    </ul>
                </div>
            </nav>
            <div class='container'>
                <!--the component view will be display below using the router-outlet-->
                <router-outlet></router-outlet>
            </div>
        </div>
    `
})
export class AppComponent {
   
}
