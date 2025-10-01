import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pagina02 } from './pagina02';

describe('Pagina02', () => {
  let component: Pagina02;
  let fixture: ComponentFixture<Pagina02>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Pagina02]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Pagina02);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
