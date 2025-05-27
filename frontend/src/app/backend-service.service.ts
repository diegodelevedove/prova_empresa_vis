import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendServiceService {
  baseUrl:string = "http://localhost:8080/backend"
  constructor(readonly http: HttpClient) { }
// Veja que as alterações de proxy e segurança são apenas para uso exemplificativo, não usado em produção.
  getFromBackend():Observable<string>{
    return this.http.get<string>(this.baseUrl)
  }
}
