import { Component, Input, OnInit } from '@angular/core';
import { ButtonSize } from 'src/app/shared';
import { IconName } from "@fortawesome/free-solid-svg-icons";

@Component({
    selector: 'app-button',
    templateUrl: './button.component.html',
    styleUrls: [ './button.component.sass' ]
})
export class ButtonComponent implements OnInit {
    @Input() text!: string;
    @Input() buttonType!: string;
    @Input() icon!: string;
    @Input() buttonSize!: ButtonSize;
    @Input() iconName!: IconName;

    constructor() {}

    ngOnInit(): void {}
}
