import { Component, Input, OnInit } from '@angular/core';

import { faEnvelope, faLock, faUser, IconName } from '@fortawesome/free-solid-svg-icons';
import { FaIconLibrary } from '@fortawesome/angular-fontawesome';

@Component({
  selector: 'app-icon',
  templateUrl: './icon.component.html',
  styleUrls: [ './icon.component.sass' ]
})
export class IconComponent implements OnInit {

  @Input() iconName!: IconName;

  constructor(library: FaIconLibrary) {
    library.addIcons(faEnvelope, faUser, faLock);
  }

  ngOnInit(): void {}

}
