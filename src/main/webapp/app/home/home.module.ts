import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { LogoModule } from '../logo/logo.module';
import { SearchModule } from '../search/search.module';
import { LogoComponent } from '../logo/logo.component';
import { SearchComponent } from '../search/search.component';
import { HomeComponent } from './home.component';

@NgModule({
    declarations: [
        LogoComponent,
        SearchComponent
    ],
    imports:[
        RouterModule.forChild([
            {path: 'home', component: HomeComponent}
        ])
    ],
    exports: [
        LogoComponent,
        SearchComponent
    ]
})

export class HomeModule{}