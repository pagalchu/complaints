import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AdminAddContent } from './admin-add-content.component';
import { AdminEditContent } from './admin-edit-content.component';
import { AdminComponent } from './admin.component';

@NgModule({
    declarations: [ 
       AdminAddContent,
       AdminEditContent
    ],
    imports: [
        RouterModule.forChild([
            {path: 'admin', component: AdminComponent}
        ])
    ],
    exports: [
        AdminAddContent,
        AdminEditContent
    ]           
})

export class AdminModule {}