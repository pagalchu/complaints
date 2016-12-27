import { Component } from '@angular/core';

@Component({
    selector: 'vault',
    template: `
        <div>
            <nav class='navbar navbar-default'>
                <div class='container-fluid'>
                    <a class='navbar-brand'>{{pageTitle}}</a>
                    <ul class='nav navbar-nav'>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Admin</a></li>
                    </ul>
                </div>
            </nav>
            <div class='container'>
                <!--the component view will be display below using the router-outlet
                <router-outlet></router-outlet>
                -->
                <h1>My Vault Application</h1>
            </div>
        </div>
    `
})
export class AppComponent { }
