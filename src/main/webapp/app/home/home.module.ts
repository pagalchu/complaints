import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SearchModule } from '../search/search.module';
import { SearchComponent } from '../search/search.component';
import { HomeComponent } from './home.component';

@NgModule({
    declarations: [
        SearchComponent
    ],
    imports:[
        RouterModule.forChild([
            {path: 'home', component: HomeComponent}
        ])
    ],
    exports: [
        SearchComponent
    ]
})

export class HomeModule{}