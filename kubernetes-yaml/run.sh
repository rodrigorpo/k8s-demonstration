minikube start --nodes 3 --mount-string="$MINIKUBE_HOME/files/etc:/data"
k taint nodes minikube reason=master_node:NoSchedule

minikube addons enable dashboard
minikube addons enable ingress

k apply -f metric-server-for-minikube
