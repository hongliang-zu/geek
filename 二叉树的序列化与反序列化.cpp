//序列化
void Serialize(BinaryTreeNode* pRoot,ostream& stream){
	if(pRoot=nullptr){
		stream<<"$,"
		return;
	}
	stream<<pRoot->m_nValue<<',';
	Serialize(pRoot->m_pLeft,stream);
	Serialize(pRppt->m_pright,stream);		
}
//反序列化
void Deserialize(BinaryTreeNode* pRoot,istream& stream){
	int number;
	if(ReadStream(stream,&number)){
		*pRoot=new BinaryTreeNode();
		(*pRoot)->m_nValue=number;
		(*pRoot)->m_pLeft=nullptr;
		(*pRoot)->m_pRight=nullptr;
		Deserialize(&((*pRoot)->m_pLeft),stream);
		Deserialize(&((*pRoot)->m_pRight),stream);
	}
} 
