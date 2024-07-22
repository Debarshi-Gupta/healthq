import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private loginService:LoginService){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        let newReq = req;
        let authToken = this.loginService.getToken();

        console.log("Interceptor", authToken);

        if(authToken!=null)
        {
            newReq = newReq.clone({setHeaders:{Authorization:`Bearer ${authToken}`}});
        }

        return next.handle(newReq);
    }
}
