build-image:
	gcloud builds submit --tag gcr.io/com-zugaldia-runtemplate/template

run-image:
	gcloud auth configure-docker
	docker run -m 512M -p 8080:8080 -e PORT=8080 gcr.io/com-zugaldia-runtemplate/template

deploy-image:
	gcloud beta run deploy --image gcr.io/com-zugaldia-runtemplate/template \
		--memory 512M
