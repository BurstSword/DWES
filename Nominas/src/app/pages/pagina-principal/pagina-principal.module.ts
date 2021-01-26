import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';
import { PaginaPrincipalComponent } from './pagina-principal.component';
import { PaginaPrincipalRoutingModule } from './pagina-principal-routing.module';


@NgModule({
  declarations: [PaginaPrincipalComponent],
  imports: [
    CommonModule,
    FormsModule,
    PaginaPrincipalRoutingModule,
    
  ]
})
export class PaginaPrincipalModule { }