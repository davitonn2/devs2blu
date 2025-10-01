import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControleServer } from './controle-server';

describe('ControleServer', () => {
  let component: ControleServer;
  let fixture: ComponentFixture<ControleServer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ControleServer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ControleServer);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
