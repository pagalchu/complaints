import { Component } from '@angular/core';

@Component({
    selector: 'vault',
    template: `
        <div>
            <nav class='navbar navbar-default'>
                <div class='container-fluid'>
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <img alt="Brand" src="app/assets/images/nav-logo.png">
                        </a>
                    </div>
                    <ul class='nav navbar-nav'>
                        <li><a [routerLink]="['/home']">Home</a></li>
                        <li><a href="#">Admin</a></li>
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
    pageTitle: string = "Vault";
 }
