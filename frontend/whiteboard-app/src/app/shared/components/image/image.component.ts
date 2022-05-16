import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: [ './image.component.sass' ]
})
export class ImageComponent implements OnInit {

  @Input() imageSource!: string;
  @Input() altText!: string;

  constructor() {}

  ngOnInit(): void {}

}
