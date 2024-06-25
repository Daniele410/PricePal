import {Component, OnInit, ViewChild} from '@angular/core';
import {catchError, map, Observable, tap, throwError} from "rxjs";
import {AsyncPipe, JsonPipe} from "@angular/common";
import {ItemDTO} from "../../models/item.dto";
import {ItemService} from "../../services/item.service";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef,
  MatTable, MatTableDataSource
} from "@angular/material/table";
import {MatSort, MatSortHeader} from "@angular/material/sort";
import {MatPaginator, PageEvent} from "@angular/material/paginator";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    AsyncPipe,
    JsonPipe,
    MatTable,
    MatCellDef,
    MatHeaderCellDef,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatHeaderRow,
    MatRow,
    MatRowDef,
    MatHeaderRowDef,
    MatSort,
    MatSortHeader,
    MatPaginator
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {

  items$: Observable<MatTableDataSource<ItemDTO>> | undefined;
  displayedColumn: string[] = ['name', 'price', 'supermarket', 'notes'] as string[];

  constructor(private itemService: ItemService) {
  }
@ViewChild(MatSort) sort: MatSort | null = null;
  @ViewChild(MatPaginator) paginator: MatPaginator | null = null;

  ngOnInit() {
    this.items$ = this.fetchAllItems().pipe(
      map(items => {
        const dataSource = new MatTableDataSource<ItemDTO>();
        dataSource.sort = this.sort;
        dataSource.paginator = this.paginator;
        dataSource.data = items;
        return dataSource;
      }));
  }

  ngAfterViewInit() {}

  fetchAllItems(): Observable<ItemDTO[]> {
    return this.itemService.fetchAllItems().pipe(
      tap(_ => console.log("Ho fecciato tutto con successo!")),
      catchError(error => {
        console.error("Qualcosa è andato storto!", error);
        return throwError(() => new Error("Qualcosa è andato storto!"));
      })
    );
  }

  handlePageEvent($event: PageEvent) {
    console.error($event);
  }

}
