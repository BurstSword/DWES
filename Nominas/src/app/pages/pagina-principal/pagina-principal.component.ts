import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/interfaces/empleado';
import { EmpleadoService } from '../../services/empleado.service';


@Component({
  selector: 'app-pagina-principal',
  templateUrl: './pagina-principal.component.html',
  styleUrls: ['./pagina-principal.component.css']
})
export class PaginaPrincipalComponent implements OnInit {

  constructor(private empleadoService:EmpleadoService) { }
  listaEmpleados: Empleado[] = [];

  
  ngOnInit(): void {
    this.listarEmpleados();
  }

  async listarEmpleados(){
    const datos= await this.empleadoService.listarEmpleados();
    this.listaEmpleados=datos;
  }

}
