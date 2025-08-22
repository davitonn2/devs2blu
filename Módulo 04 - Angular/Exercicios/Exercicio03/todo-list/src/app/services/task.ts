import { Injectable } from '@angular/core';
import { Auth } from './auth';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private authService: Auth) { }

  private getTasksKey(): string | null {
    const user = this.authService.getCurrentUser();
    return user ? `tasks_${user.email}` : null;
  }

  getTasks(): any[] {
    const key = this.getTasksKey();
    if (!key) return [];
    return JSON.parse(localStorage.getItem(key) || '[]');
  }

  addTask(task: any): void {
    const key = this.getTasksKey();
    if (!key) return;

    const tasks = this.getTasks();
    task.id = new Date().getTime(); // ID único
    task.concluida = false;
    tasks.push(task);
    localStorage.setItem(key, JSON.stringify(tasks));
  }

  updateTask(updatedTask: any): void {
    const key = this.getTasksKey();
    if (!key) return;

    let tasks = this.getTasks();
    tasks = tasks.map(task => task.id === updatedTask.id ? updatedTask : task);
    localStorage.setItem(key, JSON.stringify(tasks));
  }

  deleteTask(taskId: number): void {
    const key = this.getTasksKey();
    if (!key) return;

    let tasks = this.getTasks();
    tasks = tasks.filter(task => task.id !== taskId);
    localStorage.setItem(key, JSON.stringify(tasks));
  }
}