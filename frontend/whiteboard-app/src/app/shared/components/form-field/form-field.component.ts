import { Component, Input, OnInit } from '@angular/core';
import { AbstractControl, FormGroup } from '@angular/forms';
import { IconName } from "@fortawesome/free-solid-svg-icons";

@Component({
    selector: 'app-form-field',
    templateUrl: './form-field.component.html',
    styleUrls: [ './form-field.component.sass' ]
})
export class FormFieldComponent implements OnInit {

    @Input() label!: string;
    @Input() iconName!: IconName;
    @Input() type!: string;
    @Input() innerPattern!: string;
    @Input() innerFormControlName!: string;
    @Input() submitted!: boolean;
    @Input() control!: AbstractControl;
    @Input() formGroupParent: FormGroup;

    constructor() {}

    ngOnInit(): void {}
}
