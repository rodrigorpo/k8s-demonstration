minikube start --nodes 3 --mount-string="$MINIKUBE_HOME/files/etc:/data"
kubectl taint nodes minikube reason=master_node:NoSchedule

minikube addons enable dashboard
minikube addons enable ingress

kubectl apply -f https://k8s.io/examples/admin/dns/dnsutils.yaml
kubectl apply -f files/metric-server-for-minikube
