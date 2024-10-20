import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankingformComponent } from './bankingform.component';

describe('BankingformComponent', () => {
  let component: BankingformComponent;
  let fixture: ComponentFixture<BankingformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BankingformComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BankingformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
