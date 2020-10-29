package com.cacl.dao.impl;

import com.cacl.dao.IStack;

/**
 * �ҵ�ջ ʵ��IStack�ӿ�
 * 
 * @author Gavin
 * 
 */
public class MyStack<E> implements IStack<E> {
	private E[] elements;// Ԫ������
	private int size;// ����
	private static final int INITIAL_CAPACITY = 30;// ��ʼ��ջ��С

	/**
	 * Ĭ�ϴ�С�Ĺ��췽��
	 */
	public MyStack() {
		elements = (E[]) new Object[INITIAL_CAPACITY];// java��֧�ַ�������
	}

	/**
	 * ָ����С�Ĺ��췽��
	 * 
	 * @param capacity
	 */
	public MyStack(int capacity) {
		elements = (E[]) new Object[capacity];
	}

	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * ����ջ��Ԫ��
	 */
	public E peek() {
		if (size == 0) {
			throw new java.util.EmptyStackException();
		}
		return elements[size - 1];
	}

	/**
	 * ɾ����ǰջ��Ԫ��
	 */
	public E pop() {
		if (size == 0) {
			throw new java.util.EmptyStackException();
		}
		E element = elements[--size];
		elements[size] = null;
		return element;
	}

	/**
	 * �µ�Ԫ����ջ
	 */
	public void push(Object element) {
		if (size == elements.length) {
			resize();
		}
		elements[size++] = (E) element;
	}

	/**
	 * ����ջ��Ԫ�صĸ���
	 */
	public int size() {
		return size;
	}

	/**
	 * ���·����С�����ȷ���
	 */
	private void resize() {
		assert size == elements.length;
		Object[] a = new Object[2 * size];
		System.arraycopy(elements, 0, a, 0, size);
		elements = (E[]) a;
	}
}
