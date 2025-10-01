import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlunoForm } from './aluno-form';

describe('AlunoForm', () => {
  let component: AlunoForm;
  let fixture: ComponentFixture<AlunoForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlunoForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlunoForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
