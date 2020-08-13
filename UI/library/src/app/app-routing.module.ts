import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibraryLiatComponent} from './library/library-liat/library-liat.component'

const routes: Routes = [
  { path: 'library', component: LibraryLiatComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
