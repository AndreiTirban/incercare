import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: [ './login-form.component.sass' ]
})
export class LoginFormComponent implements OnInit {
  form: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) {}

  get getFormControls(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.form = this.formBuilder.group(
      {
        email: [ '',
          [
            Validators.required,
            Validators.pattern(/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/)
          ]
        ]
        ,
        password: [ '',
          [
            Validators.required,
          ]
        ]
      },
    );
  }

  onSubmit(): void {
    this.submitted = true;
  }
}
