import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pagina03 } from './pagina03';

describe('Pagina03', () => {
  let component: Pagina03;
  let fixture: ComponentFixture<Pagina03>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Pagina03]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Pagina03);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
