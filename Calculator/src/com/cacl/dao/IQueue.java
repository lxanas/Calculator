package com.cacl.dao;

/**
 * ���нӿ�
 * @author Gavin
 *
 * @param <E>
 */
public interface IQueue<E> {
	public void add(E element); //��β����Ԫ��
	public E element(); // ���ʶ�ͷԪ��
	public boolean isEmpty(); // �ж϶����Ƿ�Ϊ��
	public E remove(); // ɾ����ͷԪ��
	public int size(); // ����Ԫ�ظ���
}
