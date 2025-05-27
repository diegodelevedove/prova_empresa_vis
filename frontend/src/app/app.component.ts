import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BackendServiceService } from './backend-service.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.less'
})
export class AppComponent {
  title:string = 'Prova Vis'; // Técnica básica de binding de informações entre o modulo e o front
  msg:string=""

constructor(readonly backend:BackendServiceService){
  this.callService();
}
callService(){ //invocando um serviço, ex: back end e retornando os dados.
  this.backend.getFromBackend().subscribe(msg =>{this.msg = msg})
} 

}
