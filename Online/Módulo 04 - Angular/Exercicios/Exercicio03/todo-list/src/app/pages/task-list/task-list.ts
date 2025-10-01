import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Auth } from '../../services/auth';
import { TaskService } from '../../services/task';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './task-list.html',
  styleUrls: ['./task-list.css']
})
export class TaskListComponent implements OnInit {
  taskForm: FormGroup;
  tasks: any[] = [];
  currentUser: any;

  constructor(
    private fb: FormBuilder,
    public authService: Auth,
    private taskService: TaskService
  ) {
    this.taskForm = this.fb.group({
      descricao: ['', Validators.required],
      dataFinal: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.currentUser = this.authService.getCurrentUser();
    this.loadTasks();
  }

  loadTasks(): void {
    this.tasks = this.taskService.getTasks();
  }

  addTask(): void {
    if (this.taskForm.valid) {
      this.taskService.addTask(this.taskForm.value);
      this.taskForm.reset();
      this.loadTasks();
    }
  }

  deleteTask(taskId: number): void {
    if (confirm('Tem certeza que deseja remover esta tarefa?')) {
      this.taskService.deleteTask(taskId);
      this.loadTasks();
    }
  }

  toggleConcluida(task: any): void {
    task.concluida = !task.concluida;
    this.taskService.updateTask(task);
    this.loadTasks();
  }
}