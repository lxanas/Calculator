package com.cacl.dao;

/**
 * ջ�ӿ�
 * @author Gavin
 *
 * @param <E>
 */
public interface IStack <E>{
	public boolean isEmpty();//�ж��Ƿ�Ϊ��
	public E peek();//����ջ��Ԫ��
	public E pop();//ɾ��ջ��Ԫ�أ�������ջ��Ԫ��
	public void push(E element);//��Ԫ�ؽ�ջ
	public int size();//����Ԫ�ظ���
}
