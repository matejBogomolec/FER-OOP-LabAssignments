package hr.fer.oop.lab2.prob2;

/**
 * The type Tree node.
 */
class TreeNode
{
	/**
	 * The Left node.
	 */
	TreeNode left;
	/**
	 * The Right node.
	 */
	TreeNode right;
	/**
	 * The node data.
	 */
	String data;
}

/**
 * The type Tree program.
 */
class TreeProgram
{
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args)
	{
		TreeNode node = null;
		node = insert(node, "Jasna");
		node = insert(node, "Ana");
		node = insert(node, "Ivana");
		node = insert(node, "Anamarija");
		node = insert(node, "Vesna");
		node = insert(node, "Kristina");
		System.out.println("Writing tree inorder:");
		writeTree(node);
		node = reverseTreeOrder(node);
		System.out.println("Writing reversed tree inorder:");
		writeTree(node);
		int size = sizeOfTree(node);	
		System.out.println("Number of nodes in tree is "+size+".");
		boolean found = containsData(node, "Ivana");
		System.out.println("Searched element is found: "+found);
	}

	/**
	 * Contains data boolean.
	 *
	 * @param treeRoot the tree root
	 * @param data     the data
	 * @return the boolean
	 */
	static boolean containsData(TreeNode treeRoot, String data) //Metoda provjerava da li se podatak data pojavljuje u stablu
	{
		boolean contains;
		if(treeRoot==null) return false;
		else if (treeRoot.data.compareTo(data)==0) return true; //Ako rezultat medode compareTo 0 onda su nizovi isti
		else if(treeRoot.data.compareTo(data) < 0)contains = containsData(treeRoot.left, data); //Metoda dodatno provjerava leksikografki odnos pdoataka da br�e pretra�uje
		else contains = containsData(treeRoot.right, data);
		return contains;
	}

	/**
	 * Size of tree int.
	 *
	 * @param treeRoot the tree root
	 * @return the int
	 */
	static int sizeOfTree(TreeNode treeRoot) //Metoda broji koliko ima �vorova u stablu, size inicijaliziran u 1 zbog pravilnog vra�anja
	{
		int size = 1;
		if(treeRoot==null) return 0;
		size+= sizeOfTree(treeRoot.left);
		size+= sizeOfTree(treeRoot.right);
		return size;
	}

	/**
	 * Insert tree node.
	 *
	 * @param treeRoot the tree root
	 * @param data     the data
	 * @return the tree node
	 */
	static TreeNode insert(TreeNode treeRoot, String data) //Metoda postavlja novi �vor na null �vor te vra�a adresu trenutnog �vora
	{
		if(treeRoot==null)
		{
			TreeNode newTree = new TreeNode(); //Inicijalizacija novog �vora
			newTree.data = data;
			newTree.left =  null;
			newTree.right = null;
			return newTree;
		}
		if (treeRoot.data.compareTo(data)>=0) treeRoot.left = insert(treeRoot.left, data); //Povezivanje postoje�ih �vorova s novim
		else treeRoot.right = insert(treeRoot.right, data);
		return treeRoot;
	}

	/**
	 * Write tree.
	 *
	 * @param treeRoot the tree root
	 */
	static void writeTree(TreeNode treeRoot) //Metoda za inorder ispis
	{
		if(treeRoot == null) return;
		writeTree(treeRoot.left);
		System.out.println(treeRoot.data);
		writeTree(treeRoot.right);
		return;
	}

	/**
	 * Reverse tree order tree node.
	 *
	 * @param treeRoot the tree root
	 * @return the tree node
	 */
	static TreeNode reverseTreeOrder(TreeNode treeRoot) //Metoda kojom se zamjenjuju mjesta �vorova na istim razinama (zrcaljenje)
	{
		TreeNode aux = new TreeNode();
		if(treeRoot == null) return treeRoot;
		else
		{
			aux = treeRoot.left;
			treeRoot.left = treeRoot.right;
			treeRoot.right = aux;
		}
		treeRoot.left = reverseTreeOrder(treeRoot.left);
		treeRoot.right = reverseTreeOrder(treeRoot.right);
		return treeRoot;
	}

	/**
	 * Contains data 2 boolean.
	 *
	 * @param treeRoot the tree root
	 * @param data     the data
	 * @return the boolean
	 */
	static boolean containsData2(TreeNode treeRoot, String data) //Metoda slična containsData, samo je njezina složenost veća
	{ 															 // (ne gleda se leksikografski odnos traženog i trenutnog niza)
		boolean contains;
		if(treeRoot==null) return false;
		else if (treeRoot.data.compareTo(data)==0) return true;
		contains = containsData(treeRoot.left, data);
		contains = containsData(treeRoot.right, data);
		return contains;
	}
}
