class MyQueue {
public:

    stack<int> s1;
    stack<int> s2;

    MyQueue() {
        
    }
    
    void push(int x) {
        s1.push(x);
    }
    
    int pop() {
        moveElements();
        
        int x = s2.top();
        s2.pop();
        return x;
    }
    
    int peek() {
        moveElements();
        return s2.top();
    }
    
    bool empty() {
        return s1.empty() && s2.empty();
    }

private:

    void moveElements() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.top());
                s1.pop();
            }
        }
    }
};