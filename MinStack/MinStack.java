class MinStack {
    public List<Integer> stack = new ArrayList<Integer>();
    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        int last = stack.size()-1;
        if(stack.size()!=0 ){
            stack.remove(last);
        }
    }

    public int top() {
        int last = stack.size()-1;
        if(stack.size()!=0){
            return stack.get(last);
        }
        return 0;
    }

    public int getMin() {
        int last = stack.size()-1;
        Integer temp = Integer.MAX_VALUE;
        for(int i = 0 ;i<stack.size();i++){
            if(stack.get(i)<temp){
                temp = stack.get(i);
            }
        }
        return temp;
    }
}
