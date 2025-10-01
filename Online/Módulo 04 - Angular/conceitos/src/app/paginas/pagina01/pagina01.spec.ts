import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pagina01 } from './pagina01';

describe('Pagina01', () => {
  let component: Pagina01;
  let fixture: ComponentFixture<Pagina01>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Pagina01]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Pagina01);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
