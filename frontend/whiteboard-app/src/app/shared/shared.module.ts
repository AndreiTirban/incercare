import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";
import { ButtonComponent } from "./components/button/button.component";
import { CardComponent } from "./components/card/card.component";
import { FormFieldComponent } from "./components/form-field/form-field.component";
import { IconComponent } from "./components/icon/icon.component";
import { ImageComponent } from "./components/image/image.component";

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FontAwesomeModule
  ],
  declarations: [
    ButtonComponent,
    CardComponent,
    FormFieldComponent,
    IconComponent,
    ImageComponent,
  ],
  exports: [
    ButtonComponent,
    CardComponent,
    FormFieldComponent,
    IconComponent,
    ImageComponent,
    CommonModule,
    FontAwesomeModule,
    ReactiveFormsModule
  ]
})
export class SharedModule {
}

