"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var logo_component_1 = require("../logo/logo.component");
var search_component_1 = require("../search/search.component");
var home_component_1 = require("./home.component");
var HomeModule = (function () {
    function HomeModule() {
    }
    return HomeModule;
}());
HomeModule = __decorate([
    core_1.NgModule({
        declarations: [
            //HomeComponent
            logo_component_1.LogoComponent,
            search_component_1.SearchComponent
        ],
        imports: [
            //LogoModule,
            //SearchModule,
            router_1.RouterModule.forChild([
                { path: 'home', component: home_component_1.HomeComponent }
            ])
        ],
        exports: [
            logo_component_1.LogoComponent,
            search_component_1.SearchComponent
        ]
    }),
    __metadata("design:paramtypes", [])
], HomeModule);
exports.HomeModule = HomeModule;
//# sourceMappingURL=home.module.js.map