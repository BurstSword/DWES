import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Empleado } from '../interfaces/empleado';

@Injectable({
  providedIn: 'root'
})

export class EmpleadoService {

  private baseUrl = 'http://localhost:8082/controlador';

  constructor(private http:HttpClient) { }

  listarEmpleados(){
    return new Promise<Empleado[]>(resolve=>{
      this.http.get<Empleado[]>(`${this.baseUrl}`+`/lista`).subscribe(resp=>{
        resolve(resp);
      });
    });
  }

  

  obtenerSueldo(dni:String): Observable<any> {
    return this.http.post(`${this.baseUrl}`+`/sueldo`,dni);
  }

  guardarEmpleado(empleado: Empleado): Observable<any> {
    return this.http.post(`${this.baseUrl}`+'/guardarEmpleado', empleado);
  }

  borrarEmpleado(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/eliminar/${id}`, { responseType: 'text' });
  }

  cogerEmpleado(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/traerEmpleado/${id}`);
  }
  
}  