import { Component, OnInit } from '@angular/core';

@Component({
    templateUrl: 'app/admin/admin.component.html'
})

export class AdminComponent implements OnInit{
    adminMenuTitle: string = 'Admin Menu';
    adminContentTitle: string = '';
    defaultContentTitle: string = 'Add';
    add: string = 'Add';
    edit: string = 'Edit';

    ngOnInit(): void {
        this.adminContentTitle = this.defaultContentTitle;
    }

    public click(option:string): void {
        this.adminContentTitle = option;
    }
}