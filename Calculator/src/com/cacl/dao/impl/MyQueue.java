package com.cacl.dao.impl;

import com.cacl.dao.IQueue;

/**
 * �ҵĶ��У�ѭ������ ʵ��IQueue�ӿ�
 * 
 * @author Gavin
 * 
 * @param <E>
 */
public class MyQueue<E> implements IQueue<E> {
	private E[] elements;
	private int front; // ��ͷָ��
	private int rear; // ��βָ��
	private static final int INITIAL_CAPACITY = 40;
	
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public MyQueue() {
		elements = (E[]) new Object[INITIAL_CAPACITY];
		rear = front = 0;
	}

	/**
	 * ָ�����г���Ϊcapacity�Ĺ��췽��
	 * @param capacity
	 */
	public MyQueue(int capacity) {
		elements = (E[]) new Object[capacity];
		rear = front = 0;
	}

	/**
	 * ��β����Ԫ��
	 */
	public void add(E element) {
		if (size() == elements.length - 1) {
			resize();
		}
		elements[rear] = element;
		if (rear < elements.length - 1) {
			rear++;
		} else {
			rear = 0; // ����ͷ
		}
	}

	/**
	 * ���ʶ�ͷԪ��
	 */
	public E element() {
		if (size() == 0) {
			throw new java.util.NoSuchElementException();
		}
		return elements[front];
	}
	
	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}

	/**
	 * ɾ����ͷԪ��
	 */
	public E remove() {
		if (size() == 0) {
			throw new java.util.NoSuchElementException();
		}
		E element = elements[front];
		elements[front] = null;
		front++;
		if (front == rear) { // ����Ϊ��
			front = rear = 0;
		}
		if (front == elements.length) { // �ص���ͷ
			front = 0;
		}
		return element;
	}

	/**
	 * ������Ԫ�ظ���
	 */
	public int size() {
		if (front < rear) {
			return rear - front;
		} else {
			return rear - front + elements.length;
		}
	}

	/**
	 * ���·��䳤��
	 */
	private void resize() {
		int size = size();
		int len = elements.length;
		assert size == len;
		Object[] a = new Object[2 * size];
		System.arraycopy(elements, front, a, 0, len - front);
		System.arraycopy(elements, 0, a, len - front, front);
		elements = (E[]) a;
		front = 0;
		rear = size;
	}

}
