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
  title:string = 'Prova Vis';
  msg:string=""

constructor(readonly backend:BackendServiceService){
  this.callService();
}
callService(){
  this.backend.getFromBackend().subscribe(msg =>{this.msg = msg})
} 

}
