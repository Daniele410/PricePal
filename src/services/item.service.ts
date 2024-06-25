import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {ItemDTO} from "../models/item.dto";

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private baseUrl = '/api/items';

  constructor(private httpClient: HttpClient) {
  }


  fetchAllItems(page?: number, size?: number): Observable<ItemDTO[]> {
    const params: HttpParams = new HttpParams()
      .set('page', page !== undefined ? page.toString() : '0')
      .set('size', size !== undefined ? size.toString() : '10')
    return this.httpClient.get<ItemDTO[]>(this.baseUrl, {params});
  }

}
