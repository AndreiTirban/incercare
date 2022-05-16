import { NgModule, Optional, SkipSelf } from "@angular/core";
import { HeaderComponent } from "src/app/core";
import { SharedModule } from 'src/app/shared';

@NgModule({
  exports: [
    HeaderComponent
  ],
  declarations: [
    HeaderComponent
  ],
  imports: [
    SharedModule
  ]
})

export class CoreModule {
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        'CoreModule is already loaded. Import it in the AppModule only.'
      );
    }
  }
}
