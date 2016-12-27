import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

//import { LogoComponent } from '../logo/logo.component';
import { AdminComponent } from './admin.component';

@NgModule({
    declarations: [ 
       //LogoComponent
    ],
    imports: [
        RouterModule.forChild([
            {path: 'admin', component: AdminComponent}
        ])
    ],
    exports: [
        //LogoComponent
    ]           
})

export class AdminModule {}